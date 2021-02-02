import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmpresaComponent } from './empresa/empresa.component';

const routes: Routes = [
  {
    path: 'empresa', component: EmpresaComponent
  },
  {
    path: '', redirectTo: 'empresa', pathMatch: 'full' 
  },
  {
    path: '**', redirectTo: 'empresa', pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
