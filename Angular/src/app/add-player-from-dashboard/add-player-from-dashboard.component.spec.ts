import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPlayerFromDashboardComponent } from './add-player-from-dashboard.component';

describe('AddPlayerFromDashboardComponent', () => {
  let component: AddPlayerFromDashboardComponent;
  let fixture: ComponentFixture<AddPlayerFromDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddPlayerFromDashboardComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddPlayerFromDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
