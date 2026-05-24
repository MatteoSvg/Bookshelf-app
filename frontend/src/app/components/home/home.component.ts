import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

/**
 * Pagina iniziale: presenta le sezioni gestibili dell'applicazione.
 */
@Component({
  selector: 'app-home',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './home.component.html'
})
export class Home {}
