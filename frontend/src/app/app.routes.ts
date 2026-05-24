import { Routes } from '@angular/router';

/**
 * Rotte dell'applicazione. I componenti sono caricati in modalita' lazy.
 */
export const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home' },
  {
    path: 'home',
    loadComponent: () =>
      import('./components/home/home.component').then((m) => m.Home),
  },
  {
    path: 'categorie',
    loadComponent: () =>
      import('./components/categoria-list/categoria-list.component').then((m) => m.CategoriaList),
  },
  {
    path: 'autori',
    loadComponent: () =>
      import('./components/autore/autore.component').then((m) => m.AutoreList),
  },
  {
    path: 'libri',
    loadComponent: () =>
      import('./components/libro/libro.component').then((m) => m.LibroList),
  },
  {
    path: 'prestiti',
    loadComponent: () =>
      import('./components/prestito/prestito.component').then((m) => m.PrestitoList),
  },
  { path: '**', redirectTo: 'home' },
];
