import { Component, OnInit, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { Libro } from '../../models/libro.model';
import { Prestito } from '../../models/prestito.model';
import { LibroService } from '../../services/libro.service';
import { PrestitoService } from '../../services/prestito.service';

/**
 * Componente per la gestione dei Prestiti.
 * Carica anche l'elenco dei libri per popolare il menu a tendina.
 */
@Component({
  selector: 'app-prestito-list',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './prestito.component.html',
})
export class PrestitoList implements OnInit {
  private readonly prestitoService = inject(PrestitoService);
  private readonly libroService = inject(LibroService);

  prestiti: Prestito[] = [];
  libri: Libro[] = [];

  form: Prestito = this.formVuoto();
  inModifica = false;
  errore = '';

  ngOnInit(): void {
    this.carica();
    this.libroService.getAll().subscribe((dati) => (this.libri = dati));
  }

  carica(): void {
    this.prestitoService.getAll().subscribe({
      next: (dati) => (this.prestiti = dati),
      error: () => (this.errore = 'Errore nel caricamento dei prestiti.'),
    });
  }

  salva(): void {
    this.errore = '';
    if (!this.form.nomeUtente.trim()) {
      this.errore = 'Il nome utente e\u0027 obbligatorio.';
      return;
    }
    if (!this.form.libroId) {
      this.errore = 'Selezionare un libro.';
      return;
    }
    if (!this.form.dataPrestito) {
      this.errore = 'La data di prestito e\u0027 obbligatoria.';
      return;
    }
    // Il campo vuoto del date input va inviato come null
    const payload: Prestito = {
      ...this.form,
      dataRestituzione: this.form.dataRestituzione || null,
    };
    const richiesta = this.inModifica
      ? this.prestitoService.update(this.form.id!, payload)
      : this.prestitoService.create(payload);

    richiesta.subscribe({
      next: () => {
        this.annulla();
        this.carica();
      },
      error: () => (this.errore = 'Errore durante il salvataggio.'),
    });
  }

  modifica(p: Prestito): void {
    this.form = { ...p };
    this.inModifica = true;
  }

  elimina(id: number): void {
    if (!confirm('Eliminare il prestito selezionato?')) {
      return;
    }
    this.prestitoService.delete(id).subscribe({
      next: () => this.carica(),
      error: () => (this.errore = "Errore durante l'eliminazione."),
    });
  }

  annulla(): void {
    this.form = this.formVuoto();
    this.inModifica = false;
    this.errore = '';
  }

  private formVuoto(): Prestito {
    return {
      nomeUtente: '',
      dataPrestito: '',
      dataRestituzione: null,
      libroId: 0,
    };
  }
}
