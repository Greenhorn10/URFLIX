import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AboutMovieComponent } from './about-movieEntity.component';

describe('AboutMovieComponent', () => {
  let component: AboutMovieComponent;
  let fixture: ComponentFixture<AboutMovieComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AboutMovieComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AboutMovieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
