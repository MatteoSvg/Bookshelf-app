import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';

import { API_BASE_URL } from '../core/api.config';
import { Prestito } from '../models/prestito.model';

/**
 * Service che incapsula le chiamate HTTP alle API /api/prestiti.
 */
@Injectable({ providedIn: 'root' })
export class PrestitoService {
  private readonly http = inject(HttpClient);
  private readonly url = `${API_BASE_URL}/prestiti`;

  getAll(): Observable<Prestito[]> {
    return this.http.get<Prestito[]>(this.url);
  }

  getById(id: number): Observable<Prestito> {
    return this.http.get<Prestito>(`${this.url}/${id}`);
  }

  create(prestito: Prestito): Observable<Prestito> {
    return this.http.post<Prestito>(this.url, prestito);
  }

  update(id: number, prestito: Prestito): Observable<Prestito> {
    return this.http.put<Prestito>(`${this.url}/${id}`, prestito);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`);
  }
}
