import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Empresa } from '../models/empresa';

@Injectable({
  providedIn: 'root'
})
export class EmpresaService {

  pathApi = 'http://127.0.0.1:8080/empresa';

  constructor(
    private http: HttpClient
  ) { }

  // METODO RESPONSAVEL POR PERSISTIR OBJETO NO BANCO
  save(pEmpresa: Empresa) {
    return this.http.post<Empresa>(`${this.pathApi}`, pEmpresa);
  }

  // RECUPERA TODAS EMPRESAS DO BANCO SEM FILTRO
  findAll(): Observable<Empresa[]> {
    return this.http.get<Empresa[]>(`${this.pathApi}`);
  }

  // DELETA UMA EMPRESA
  delete(codId: number) {
    return this.http.delete(`${this.pathApi}/${codId}`);
  }
}
