/* tslint:disable */
import { Component, OnInit } from '@angular/core';
import {ClientService} from '../service/client.service';
import {Client} from '../model/client';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Session} from '../model/session';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  client: Client = new Client();
  session: Session = new Session();
  loginForm = new FormGroup({
    login: new FormControl(null, [Validators.required]),
    motPasse: new FormControl(null, [Validators.required])
  })
  constructor(private clientService : ClientService,
              private route: Router) { }

  ngOnInit(): void {

  }

  get login(){
    return this.loginForm.get('login');
  }
  get motPasse(){
    return this.loginForm.get('motPasse');
  }
  authentification(){
    this.clientService.login(this.login.value, this.motPasse.value).subscribe(data=>{
      this.client = data as Client;
      if(this.client === null){
        console.log(null);
      }else{
        this.clientService.addSession(this.client.id).subscribe(data=>{
          this.session = data as Session;
          console.log(this.session);
          localStorage.setItem('idClient',this.client.id.toString());
          localStorage.setItem('nomClient',this.client.nom);
          localStorage.setItem('prenomClient',this.client.prenom);
          localStorage.setItem('idSession',this.session.id.toString());
          this.route.navigate(['/calculatrice']);

        },error => console.log(error))
      }

    },error => console.log(error));
  }

}
