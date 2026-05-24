/** Modello del Prestito, speculare al PrestitoDto del backend. */
export interface Prestito {
  id?: number;
  nomeUtente: string;
  dataPrestito: string;
  dataRestituzione?: string | null;
  libroId: number;
  libroTitolo?: string;
}
