/* tslint:disable */
import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {ClientService} from '../service/client.service';
import {Operation} from '../model/operation';

@Component({
  selector: 'app-calculatrice',
  templateUrl: './calculatrice.component.html',
  styleUrls: ['./calculatrice.component.css']
})
export class CalculatriceComponent implements OnInit {
  ope : string = "";
  resultat: number = null;
  operation = new Operation();
  resultatOperation = new Operation();
  nom: string = localStorage.getItem('nomClient')+" "+ localStorage.getItem('prenomClient');
  calculForm = new FormGroup({
    valeur1: new FormControl(null, [Validators.required]),
    valeur2: new FormControl(null, [Validators.required]),
    op: new FormControl(null),
    res: new FormControl(null)
  })
  constructor(private route: Router,
              private clientService : ClientService) { }

  ngOnInit(): void {

  }

  calculatrice(){
    this.operation.type = this.ope;
    this.operation.value1 = this.valeur1.value;
    this.operation.value2 = this.valeur2.value;
    this.clientService.addOperation(parseInt(localStorage.getItem('idSession')),this.operation).subscribe(data=>{
      this.resultatOperation = data as Operation;
      this.resultat = this.resultatOperation.resultat;
      console.log(this.resultatOperation);
    },error => console.log(error))
  }
  addition(){

    this.ope = "+"

  }
  soustration(){
    this.ope = "-"
  }
  division(){
    this.ope = "/"
  }
  multiplication(){
    this.ope = "*"
  }


  deconnexion(){
    this.clientService.closeSeession(parseInt(localStorage.getItem('idSession'))).subscribe(data=>{
      console.log("déconnexion")
      localStorage.clear();
      this.route.navigate(['/']);
    },error => console.log(error))

  }


  get valeur1(){
    return this.calculForm.get('valeur1');
  }
  get valeur2(){
    return this.calculForm.get('valeur2');
  }
  get op(){
    return this.calculForm.get('op');
  }
  get res(){
    return this.calculForm.get('res')
  }


}
