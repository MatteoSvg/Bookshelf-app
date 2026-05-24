import { Component, OnInit, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { Autore } from '../../models/autore.model';
import { Categoria } from '../../models/categoria.model';
import { Libro } from '../../models/libro.model';
import { AutoreService } from '../../services/autore.service';
import { CategoriaService } from '../../services/categoria.service';
import { LibroService } from '../../services/libro.service';

/**
 * Componente per la gestione dei Libri.
 * Carica anche autori e categorie per popolare i menu a tendina.
 */
@Component({
  selector: 'app-libro',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './libro.component.html',
})
export class LibroList implements OnInit {
  private readonly libroService = inject(LibroService);
  private readonly autoreService = inject(AutoreService);
  private readonly categoriaService = inject(CategoriaService);

  libri: Libro[] = [];
  autori: Autore[] = [];
  categorie: Categoria[] = [];

  form: Libro = this.formVuoto();
  inModifica = false;
  errore = '';

  ngOnInit(): void {
    this.carica();
    this.autoreService.getAll().subscribe((dati) => (this.autori = dati));
    this.categoriaService.getAll().subscribe((dati) => (this.categorie = dati));
  }

  carica(): void {
    this.libroService.getAll().subscribe({
      next: (dati) => (this.libri = dati),
      error: () => (this.errore = 'Errore nel caricamento dei libri.'),
    });
  }

  salva(): void {
    this.errore = '';
    if (!this.form.titolo.trim()) {
      this.errore = 'Il titolo e\u0027 obbligatorio.';
      return;
    }
    if (!this.form.autoreId || !this.form.categoriaId) {
      this.errore = 'Selezionare autore e categoria.';
      return;
    }
    const richiesta = this.inModifica
      ? this.libroService.update(this.form.id!, this.form)
      : this.libroService.create(this.form);

    richiesta.subscribe({
      next: () => {
        this.annulla();
        this.carica();
      },
      error: () => (this.errore = 'Errore durante il salvataggio.'),
    });
  }

  modifica(l: Libro): void {
    this.form = { ...l };
    this.inModifica = true;
  }

  elimina(id: number): void {
    if (!confirm('Eliminare il libro selezionato?')) {
      return;
    }
    this.libroService.delete(id).subscribe({
      next: () => this.carica(),
      error: () => (this.errore = "Errore durante l'eliminazione."),
    });
  }

  annulla(): void {
    this.form = this.formVuoto();
    this.inModifica = false;
    this.errore = '';
  }

  private formVuoto(): Libro {
    return {
      titolo: '',
      isbn: '',
      annoPubblicazione: undefined,
      disponibile: true,
      autoreId: 0,
      categoriaId: 0,
    };
  }
}
