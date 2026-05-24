import { Component, OnInit, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { Autore } from '../../models/autore.model';
import { AutoreService } from '../../services/autore.service';

/**
 * Componente per la gestione degli Autori: elenco, creazione,
 * modifica ed eliminazione tramite le API REST.
 */
@Component({
  selector: 'app-autore',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './autore.component.html'
})

export class AutoreList implements OnInit {
  private readonly service = inject(AutoreService);

  autori: Autore[] = [];
  form: Autore = { nome: '', cognome: '', nazionalita: '' };
  inModifica = false;
  errore = '';

  ngOnInit(): void {
    this.carica();
  }

  carica(): void {
    this.service.getAll().subscribe({
      next: (dati) => (this.autori = dati),
      error: () => (this.errore = 'Errore nel caricamento degli autori.'),
    });
  }

  salva(): void {
    this.errore = '';
    if (!this.form.nome.trim() || !this.form.cognome.trim()) {
      this.errore = 'Nome e cognome sono obbligatori.';
      return;
    }
    const richiesta = this.inModifica
      ? this.service.update(this.form.id!, this.form)
      : this.service.create(this.form);

    richiesta.subscribe({
      next: () => {
        this.annulla();
        this.carica();
      },
      error: () => (this.errore = 'Errore durante il salvataggio.'),
    });
  }

  modifica(a: Autore): void {
    this.form = { ...a };
    this.inModifica = true;
  }

  elimina(id: number): void {
    if (!confirm('Eliminare l\u0027autore selezionato?')) {
      return;
    }
    this.service.delete(id).subscribe({
      next: () => this.carica(),
      error: () => (this.errore = "Errore durante l'eliminazione."),
    });
  }

  annulla(): void {
    this.form = { nome: '', cognome: '', nazionalita: '' };
    this.inModifica = false;
    this.errore = '';
  }
}
