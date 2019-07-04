import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PessoaService {

  uri = 'http://localhost:8080/pessoas';

  constructor(private http: HttpClient) { }

  addPessoa(nomePessoa) {
    
    const obj = {
      nomePessoa
    };

    console.log(obj);
    this.http.post(`${this.uri}`, obj)
        .subscribe(res => console.log('Done'));
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
}
