import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';

/**
 * Componente radice: contiene la navbar Bootstrap e il router-outlet.
 */
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterLink, RouterLinkActive],
  template: `
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary shadow-sm">
      <div class="container">
        <a class="navbar-brand fw-bold" routerLink="/home">📚 Biblioteca</a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#mainNav">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mainNav">
          <ul class="navbar-nav ms-auto">
            <li class="nav-item">
              <a class="nav-link" routerLink="/home" routerLinkActive="active">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" routerLink="/categorie" routerLinkActive="active">Categorie</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" routerLink="/autori" routerLinkActive="active">Autori</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" routerLink="/libri" routerLinkActive="active">Libri</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" routerLink="/prestiti" routerLinkActive="active">Prestiti</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <main class="container py-4">
      <router-outlet />
    </main>

    <footer class="text-center text-muted py-4 small">
      Progetto di esempio &middot; Angular 21 + Spring Boot 4 + H2
    </footer>
  `,
})
export class App {}
