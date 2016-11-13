import {Component, OnInit} from "@angular/core";
import {HttpService} from "../http.service";
import {Field} from "../domain/field";

@Component({
  selector: 'app-minesweeper',
  templateUrl: './minesweeper.component.html',
  styleUrls: ['./minesweeper.component.css']
})
export class MinesweeperComponent implements OnInit {

  private sweeperBoxes: Field[][];

  constructor(private httpService: HttpService) {
  }

  ngOnInit() {
    this.sweeperBoxes=this.httpService.getFields();
  }

  leftClick = (field: Field) => {

  }

  rightClick = (field:Field) =>{

  }
}
