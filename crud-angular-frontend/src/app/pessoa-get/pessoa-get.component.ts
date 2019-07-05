import { Component, OnInit } from '@angular/core';
import { PessoaService } from '../services/pessoa.service';
import Pessoa from '../models/Pessoa';

@Component({
  selector: 'app-pessoa-get',
  templateUrl: './pessoa-get.component.html',
  styleUrls: ['./pessoa-get.component.css']
})
export class PessoaGetComponent implements OnInit {

  pessoas: Pessoa[];

  constructor(private ps: PessoaService) { }

  ngOnInit() {
    this.ps
      .getPessoa()
      .subscribe((data: Pessoa[]) => {
        this.pessoas = data;
    });
  }

  remove(pessoa) {
    this.ps.deletePessoa(pessoa.idPessoa).subscribe(res => {
      var index = this.pessoas.indexOf(pessoa);
      this.pessoas.splice(index, 1);
    });
  }
}
