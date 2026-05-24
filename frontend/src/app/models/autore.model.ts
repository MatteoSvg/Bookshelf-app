/** Modello dell'Autore, speculare all'AutoreDto del backend. */
export interface Autore {
  id?: number;
  nome: string;
  cognome: string;
  nazionalita?: string;
}
