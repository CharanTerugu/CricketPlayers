import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateLoginsComponent } from './create-logins.component';

describe('CreateLoginsComponent', () => {
  let component: CreateLoginsComponent;
  let fixture: ComponentFixture<CreateLoginsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateLoginsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateLoginsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
