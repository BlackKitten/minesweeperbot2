import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { MinesweeperComponent } from './minesweeper/minesweeper.component';
import { SweeperboxComponent } from './sweeperbox/sweeperbox.component';
import {HttpService} from "./http.service";

@NgModule({
  declarations: [
    AppComponent,
    MinesweeperComponent,
    SweeperboxComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [
    HttpService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
