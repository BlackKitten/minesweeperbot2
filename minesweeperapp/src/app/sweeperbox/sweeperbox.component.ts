import {Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import {HttpService} from "../http.service";
import {Field} from "../domain/field";

@Component({
  selector: 'sweeperbox',
  templateUrl: './sweeperbox.component.html',
  styleUrls: ['./sweeperbox.component.css']
})
export class SweeperboxComponent implements OnInit {

  @Input() field:Field;
  @Output() leftClick = new EventEmitter<Field>();
  @Output() rightClick = new EventEmitter<Field>();

  constructor(private httpService:HttpService) {
  }

  questionMark:boolean = false;
  clicked:boolean = false;

  ngOnInit() {
    this.field.click.subscribe(() => {this.left()});
  }



  left = () => {
    if(!this.questionMark && !this.clicked) {
      this.clicked = true;
      this.field.value = this.httpService.get(this.field.x, this.field.y);
      this.leftClick.emit(this.field);
    }
  }

  right = () => {
    if(!this.clicked) {
      this.toggleQuestionMark();
      this.rightClick.emit(this.field);
    }
  }

  toggleQuestionMark = () => {
    this.questionMark = !this.questionMark;
  }

  getValue = ():String => {
    if (this.clicked) {
      return "" + this.field.value;
    }

    if (this.questionMark) {
      return "?";
    }

    return "  ";
  }

}
