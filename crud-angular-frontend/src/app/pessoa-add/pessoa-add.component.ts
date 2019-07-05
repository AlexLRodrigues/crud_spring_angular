import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { PessoaService } from '../services/pessoa.service';
import { EstadoService } from '../services/estado.service';
import Pessoa from '../models/Pessoa';
import Estado from '../models/Estado';
import Documento from '../models/Documento';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pessoa-add',
  templateUrl: './pessoa-add.component.html',
  styleUrls: ['./pessoa-add.component.css']
})
export class PessoaAddComponent implements OnInit {

  private pessoa = new Pessoa();

  public estados = [];

  private documentos = [];

  private documento = {};


  constructor(private httpClient: HttpClient,
    private ps: PessoaService,
    private es: EstadoService,
    private router: Router
    ) {
  }

  ngOnInit() {
    this.es
      .getEstado()
      .subscribe((data: Estado[]) => {
        this.estados = data;
    });

  }

  onSubmit() { 
    let listaDocumento: Documento [] = [];

    this.documentos.forEach(documento => {
      let doc = new Documento(documento.tipoDocumento, documento.numeroDocumento);
      listaDocumento.push(doc);
    });

    this.pessoa.listaDocumento = listaDocumento;
    
    this.ps.addPessoa(this.pessoa).then(() => {
      this.router.navigate(['/pessoas'])
    });
  }

  addDocumento() {
    this.documentos.push(this.documento);
    this.documento = {};
  }

  removeDocument(documento){
    var index = this.documentos.indexOf(documento);
    this.documentos.splice(index, 1);
  }

}
