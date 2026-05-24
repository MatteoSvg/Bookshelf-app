/** Modello del Libro, speculare al LibroDto del backend. */
export interface Libro {
  id?: number;
  titolo: string;
  isbn?: string;
  annoPubblicazione?: number;
  disponibile: boolean;
  autoreId: number;
  autoreNomeCompleto?: string;
  categoriaId: number;
  categoriaNome?: string;
}
