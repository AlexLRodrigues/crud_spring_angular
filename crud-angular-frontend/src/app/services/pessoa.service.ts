import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PessoaService {

  uri = 'http://localhost:8080/pessoas';

  constructor(private http: HttpClient) { }

  addPessoa(pessoa) {
    return this.http.post(`${this.uri}`, pessoa)
      .toPromise();
  }

  getPessoa() {
    return this
           .http
           .get(`${this.uri}`);
  }

  deletePessoa(id) {
    return this
              .http
              .delete(`${this.uri}/${id}`);
  }

  buscarPessoaPorID(id) {
    return this
            .http
            .get(`${this.uri}/${id}`);
  }

  atualizarPessoa(pessoa){
    return this.http.put(`${this.uri}`, pessoa)
    .toPromise();
  }
}
