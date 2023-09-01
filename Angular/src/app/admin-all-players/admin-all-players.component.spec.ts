import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAllPlayersComponent } from './admin-all-players.component';

describe('AdminAllPlayersComponent', () => {
  let component: AdminAllPlayersComponent;
  let fixture: ComponentFixture<AdminAllPlayersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminAllPlayersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminAllPlayersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
