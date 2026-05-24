import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';

import { API_BASE_URL } from '../core/api.config';
import { Libro } from '../models/libro.model';

/**
 * Service che incapsula le chiamate HTTP alle API /api/libri.
 */
@Injectable({ providedIn: 'root' })
export class LibroService {
  private readonly http = inject(HttpClient);
  private readonly url = `${API_BASE_URL}/libri`;

  getAll(): Observable<Libro[]> {
    return this.http.get<Libro[]>(this.url);
  }

  getById(id: number): Observable<Libro> {
    return this.http.get<Libro>(`${this.url}/${id}`);
  }

  create(libro: Libro): Observable<Libro> {
    return this.http.post<Libro>(this.url, libro);
  }

  update(id: number, libro: Libro): Observable<Libro> {
    return this.http.put<Libro>(`${this.url}/${id}`, libro);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`);
  }
}
