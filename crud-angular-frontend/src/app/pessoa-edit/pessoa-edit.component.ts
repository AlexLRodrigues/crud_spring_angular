import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PessoaService } from '../services/pessoa.service';
import { EstadoService } from '../services/estado.service';
import Pessoa from '../models/Pessoa';
import Estado from '../models/Estado';

@Component({
  selector: 'app-pessoa-edit',
  templateUrl: './pessoa-edit.component.html',
  styleUrls: ['./pessoa-edit.component.css']
})
export class PessoaEditComponent implements OnInit {

  pessoa : any = {};
  estados = [];
  estado : any = {};
  estadoSelecionado: Number;
  documento : any = {};
  documentos : any = [];

  constructor(
    private route: ActivatedRoute, 
    private router: Router,
    private ps: PessoaService,
    private es: EstadoService
    ) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
        this.ps.buscarPessoaPorID(params['idPessoa']).subscribe(res => {
          this.es
            .getEstado()
            .subscribe((data: Estado[]) => {
              this.estados = data;
              this.pessoa = res;

              if (this.pessoa.estado) {
                this.estadoSelecionado = this.pessoa.estado.idEstado;
              }
          });
      });
    });
  }


  onSubmit() { 
    this.pessoa.estado.idEstado = this.estadoSelecionado;

    console.log(this.pessoa);
    this.ps.atualizarPessoa(this.pessoa).then(() => {
      this.router.navigate(['/pessoas'])
    });
  }

  addDocumento() {
    this.pessoa.listaDocumento.push(this.documento);
    this.documento = {};
  }

  removeDocument(documento){
    var index = this.pessoa.listaDocumento.indexOf(documento);
    this.pessoa.listaDocumento.splice(index, 1);
  }

}
