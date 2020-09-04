import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { LoginComponent } from './login/login.component';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { AlertComponent } from './alert/alert.component';
import {RestapiService} from './restapi.service';
import { HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms'
 

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    AlertComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [RestapiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
