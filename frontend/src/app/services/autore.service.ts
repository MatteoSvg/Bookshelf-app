import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';

import { API_BASE_URL } from '../core/api.config';
import { Autore } from '../models/autore.model';

/**
 * Service che incapsula le chiamate HTTP alle API /api/autori.
 */
@Injectable({ providedIn: 'root' })
export class AutoreService {
  private readonly http = inject(HttpClient);
  private readonly url = `${API_BASE_URL}/autori`;

  getAll(): Observable<Autore[]> {
    return this.http.get<Autore[]>(this.url);
  }

  getById(id: number): Observable<Autore> {
    return this.http.get<Autore>(`${this.url}/${id}`);
  }

  create(autore: Autore): Observable<Autore> {
    return this.http.post<Autore>(this.url, autore);
  }

  update(id: number, autore: Autore): Observable<Autore> {
    return this.http.put<Autore>(`${this.url}/${id}`, autore);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`);
  }
}
