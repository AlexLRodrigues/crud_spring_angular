import { Component, OnInit } from '@angular/core';
import {HttpClient} from  "@angular/common/http";

@Component({
  selector: 'app-pessoa-add',
  templateUrl: './pessoa-add.component.html',
  styleUrls: ['./pessoa-add.component.css']
})
export class PessoaAddComponent implements OnInit {

  private pessoas  = [];

  constructor(private httpClient: HttpClient) { 
  }

  ngOnInit() {
  }

  get_pessoas(){ 
    this.httpClient.get('http://localhost:8080/pessoas').subscribe((res)=>{
        console.log(res);
    });
  }

}
