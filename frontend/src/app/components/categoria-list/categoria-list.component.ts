import { Component, OnInit, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { Categoria } from '../../models/categoria.model';
import { CategoriaService } from '../../services/categoria.service';

/**
 * Componente per la gestione delle Categorie: elenco, creazione,
 * modifica ed eliminazione tramite le API REST.
 */
@Component({
  selector: 'app-categoria-list',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './categoria-list.component.html'
})


export class CategoriaList implements OnInit {
  private readonly service = inject(CategoriaService);

  categorie: Categoria[] = [];
  form: Categoria = { nome: '', descrizione: '' };
  inModifica = false;
  errore = '';

  ngOnInit(): void {
    this.carica();
  }

  carica(): void {
    this.service.getAll().subscribe({
      next: (dati) => (this.categorie = dati),
      error: () => (this.errore = 'Errore nel caricamento delle categorie.'),
    });
  }

  salva(): void {
    this.errore = '';
    if (!this.form.nome.trim()) {
      this.errore = "Il nome della categoria e' obbligatorio.";
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

  modifica(c: Categoria): void {
    this.form = { ...c };
    this.inModifica = true;
  }

  elimina(id: number): void {
    if (!confirm('Eliminare la categoria selezionata?')) {
      return;
    }
    this.service.delete(id).subscribe({
      next: () => this.carica(),
      error: () => (this.errore = "Errore durante l'eliminazione."),
    });
  }

  annulla(): void {
    this.form = { nome: '', descrizione: '' };
    this.inModifica = false;
    this.errore = '';
  }
}
