import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewTeamsUserComponent } from './view-teams-user.component';

describe('ViewTeamsUserComponent', () => {
  let component: ViewTeamsUserComponent;
  let fixture: ComponentFixture<ViewTeamsUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewTeamsUserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewTeamsUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
