import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PessoaAddComponent } from './pessoa-add/pessoa-add.component';
import { PessoaGetComponent } from './pessoa-get/pessoa-get.component';
import { PessoaEditComponent } from './pessoa-edit/pessoa-edit.component';

const routes: Routes = [
  {
    path: 'pessoas/criar',
    component: PessoaAddComponent
  },
  {
    path: 'editar/:idPessoa',
    component: PessoaEditComponent
  },
  {
    path: 'pessoas',
    component: PessoaGetComponent
  },
  {
    path: '',
    component: PessoaGetComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
