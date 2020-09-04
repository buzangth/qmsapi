import { Component, OnInit } from '@angular/core';
import { RestapiService } from '../restapi.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  firstname:string;
  surname:string;
  username:string;
  password:string;
  branch:string;

  constructor(private service: RestapiService) { }

  ngOnInit(): void {

  }

  doCreateNewUser(){
    let resp =this.service.createNewUser(this.firstname,this.surname,this.username,this.password,this.branch);
    resp.subscribe(data=>{
      console.log(data);
    })
  }

}
