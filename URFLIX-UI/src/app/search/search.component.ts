import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {
  language : string;
  holder: string;

  constructor(private router: Router) { }

  ngOnInit(): void {
    this.language = 'en';
    this.holder = 'what are you looking for?';
  }
  
  search(query: string) {
    if (/\S/.test(query)) {
      this.router.navigate(['/search', query]);
    }
  }

}
