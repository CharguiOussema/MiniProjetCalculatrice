/* tslint:disable */
import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Operation} from '../model/operation';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  apipath: string;
  constructor(private http: HttpClient) {
    this.apipath = environment.apipath;
  }
  login(login: string, motPasse: string){
    return this.http.get(this.apipath+"/login/"+login+"/"+motPasse);
  }
  addSession(id: number){
    return this.http.get(this.apipath+"/addSession/"+id);
  }
  closeSeession(id: number){
    return this.http.get(this.apipath+"/closeSeession/"+id);
  }
  addOperation(id: number,operation: Operation){
    return this.http.post(this.apipath+"/addOperation/"+id,operation);
  }
  // test getAll
  getAllClient(){
    return this.http.get(this.apipath+"/getAll");
  }

}
