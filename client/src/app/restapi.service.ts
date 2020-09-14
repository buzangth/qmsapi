import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RestapiService {

  constructor(private http:HttpClient) { }

  public createNewUser(firstname:string,surname:string,username:string,password:string,branch:string){

    const headers = new HttpHeaders({Authorization: 'Basic' + btoa(firstname+":"+surname+":"+username+":"+password+":"+branch)})
    return this.http.post("http://localhost:5000/api/v1/users/createUser",{headers,responseType:'text' as 'json'});
  }

  public logIn(username:string,password:string){
    const headers = new HttpHeaders({Authorization: 'Basic' + btoa(username+":"+password+":")})
    return this.http.get("http://localhost:5000/",{headers,responseType:'text' as 'json'})
  }
}
