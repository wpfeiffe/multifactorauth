import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActivitiesParksComponent } from './activities-parks.component';

describe('ActivitiesParksComponent', () => {
  let component: ActivitiesParksComponent;
  let fixture: ComponentFixture<ActivitiesParksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ActivitiesParksComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ActivitiesParksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
