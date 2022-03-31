/* tslint:disable */
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from './login/login.component';
import {CalculatriceComponent} from './calculatrice/calculatrice.component';

const routes: Routes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'calculatrice',
    component: CalculatriceComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
