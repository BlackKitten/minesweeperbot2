/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { SweeperboxComponent } from './sweeperbox.component';

describe('SweeperboxComponent', () => {
  let component: SweeperboxComponent;
  let fixture: ComponentFixture<SweeperboxComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SweeperboxComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SweeperboxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
