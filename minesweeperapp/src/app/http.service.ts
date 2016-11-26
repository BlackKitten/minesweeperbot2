import {Injectable} from '@angular/core';
import {Field} from "./domain/field";

@Injectable()
export class HttpService {

  publicFields: Field[][];
  bombFields: boolean[][];

  constructor() {
    this.createFields();
    this.placeBombs();
  }

  private yMax: number = 10;
  private xMax: number = 10;
  private bombNumber: number = 10;

  private createFields() {
    this.bombFields = [];
    this.publicFields = [];
    for (let x = 0; x < this.xMax; x++) {
      this.publicFields[x] = [];
      this.bombFields[x] = [];
      for (let y = 0; y < this.yMax; y++) {
        this.publicFields[x][y] = new Field(x, y);
        this.bombFields[x][y] = false;
      }
    }

    this.publicFields.forEach(
      (fieldArray:Field[], index:Number, fields:Field[][]) => {
          fieldArray.forEach(
            (field:Field) => {
              field.surroundingFields = this.getSurroundingFields(field);
            }
          );
      }
    );
  }


  private getSurroundingFields(field: Field) : Field[] {
    let surroundingFields : Field[] = [];

    for(let x=field.x-1; x<=field.x+1; x++) {
      for(let y=field.y-1; y<=field.y+1; y++) {
        if( (x>=0 && x<this.xMax) && (y>=0 && y<this.yMax) ) {
          surroundingFields.push(this.publicFields[x][y]);
        }
      }
    }

    return surroundingFields;

  }

  private placeBombs() {

    let placedBombs = 0;
    while (placedBombs < this.bombNumber) {
      let randX: number = (Math.round(Math.random() * (this.yMax-1)));
      let randY: number = (Math.round(Math.random() * (this.xMax-1)));
      console.log("("+randX+","+randY+")");
      if (!this.bombFields[randX][randY]) {
        this.bombFields[randX][randY] = true;
        placedBombs++;
      }
    }
  }

  getFields = (): Field[][] => {
    return this.publicFields;
  }

  get(x: number, y: number) {
    if(this.bombFields[x][y]){
      console.log("boom");
      return 10;
    }

    var surroundingBombs:number = 0;
    for (let ix = x - 1; ix <= x + 1; ix++) {
      for (let iy = y - 1; iy <= y + 1; iy++) {
        if(ix >=0 && iy>=0 && ix<this.xMax && iy<this.yMax) {
          if (this.bombFields[ix][iy]) {
            surroundingBombs++;
          }
        }
      }
    }
    return surroundingBombs;
  }
}
