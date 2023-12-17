import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MfacodeComponent } from './mfacode.component';

describe('MfacodeComponent', () => {
  let component: MfacodeComponent;
  let fixture: ComponentFixture<MfacodeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MfacodeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MfacodeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
