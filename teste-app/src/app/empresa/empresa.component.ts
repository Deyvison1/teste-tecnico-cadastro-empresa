import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Empresa } from '../models/empresa';
import { EmpresaService } from '../services/empresa.service';

@Component({
  selector: 'app-empresa',
  templateUrl: './empresa.component.html',
  styleUrls: ['./empresa.component.css']
})
export class EmpresaComponent implements OnInit {

  // VARIAVEIS TIPO REFERENCIA
  form: FormGroup;
  empresas: Empresa[] = [];

  // VARIAVEIS TIPO PRIMITIVO
  pageAtual = 1;

  constructor(
    private fb: FormBuilder,
    private empresaService: EmpresaService
  ) { }

  ngOnInit(): void {
    this.createEmpresa();
    this.findAll();
  }

  deletar(codId: number) {
    this.empresaService.delete(codId).subscribe(
      (resposta) => {
        if(resposta) {
          alert('Sucesso ao deletar empresa!');
          this.ngOnInit();
        } else {
          alert('Error ao deletar empresa!');
        }
      }
    );
  }

  findAll() {
    this.empresaService.findAll().subscribe(
      (empresas: Empresa[]) => {
        this.empresas = empresas;
      }, err => {

      }
    );
  }

  save() {
    let empresa = this.form.value;
    if(empresa.txNome == null) {
      alert('Preencha o campo nome, ele e obrigatório!');
      return;
    }
    this.empresaService.save(empresa).subscribe(
      (empresaSalva: Empresa) => {
        this.ngOnInit();
        alert(`Empresa ${empresaSalva.txNome} salva com sucesso!`);
      }, err => {
        alert(`Ocorreu um error`);
      }
    );
  }


  createEmpresa() {
    this.form = this.fb.group({
      txNome: [null],
      cod: []
    });
  }

}
