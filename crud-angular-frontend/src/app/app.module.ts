import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PessoaAddComponent } from './pessoa-add/pessoa-add.component';
import { PessoaGetComponent } from './pessoa-get/pessoa-get.component';
import { PessoaEditComponent } from './pessoa-edit/pessoa-edit.component';

import { SlimLoadingBarModule } from 'ng2-slim-loading-bar';
import { HttpClientModule } from '@angular/common/http';

import { PessoaService } from './services/pessoa.service';
import { EstadoService } from './services/estado.service';
import { FormsModule }   from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    PessoaAddComponent,
    PessoaGetComponent,
    PessoaEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SlimLoadingBarModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    PessoaService,
    EstadoService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
