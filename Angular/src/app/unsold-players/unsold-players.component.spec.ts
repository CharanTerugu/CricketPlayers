import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UnsoldPlayersComponent } from './unsold-players.component';

describe('UnsoldPlayersComponent', () => {
  let component: UnsoldPlayersComponent;
  let fixture: ComponentFixture<UnsoldPlayersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UnsoldPlayersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UnsoldPlayersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
