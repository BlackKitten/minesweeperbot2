import {EventEmitter} from "@angular/core";
export class Field {

  constructor(x: number, y: number) {
    this.x = x;
    this.y = y;
  }

  x:number;
  y:number;
  value:number;

  click = new EventEmitter();

  surroundingFields : Field[];

}
