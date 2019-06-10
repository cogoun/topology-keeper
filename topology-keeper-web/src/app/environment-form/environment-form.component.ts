import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { Environment } from '../Environment'
import { EnvironmentService } from '../environment.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-environment-form',
  templateUrl: './environment-form.component.html',
  styleUrls: ['./environment-form.component.css']
})
export class EnvironmentFormComponent implements OnInit {

  model = new Environment(-1, '');

  submitted = false;

  constructor(private router: Router, 
    private route: ActivatedRoute,
    private environmentService: EnvironmentService) {}

  onSubmit() { 
    this.environmentService.submit(this.model).subscribe(result => {
      this.submitted = true;
      this.model = result;
    });
    
  }
  
  newEnvironment() {
    this.model = new Environment(1, '');
  }

  getEnvironment() {
    const id = +this.route.snapshot.paramMap.get('id');
    if (id) this.environmentService.getEnvironment(id).subscribe(environment => this.model = environment);
  }

  isEmptyModel(): boolean {
    if (this.model) return false;
    return true;
  }

  navigateToEnvironments() {
    this.router.navigate(['/environments']);
  }

  ngOnInit() {
    this.getEnvironment();
  }

}
