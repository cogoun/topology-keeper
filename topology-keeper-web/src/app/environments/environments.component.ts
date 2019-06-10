import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { EnvironmentService } from '../environment.service';
import { Environment } from '../Environment';


@Component({
  selector: 'app-environments',
  templateUrl: './environments.component.html',
  styleUrls: ['./environments.component.css']
})
export class EnvironmentsComponent implements OnInit {

  environments: Environment[] = [];

  constructor(private router: Router, 
    private environmentService: EnvironmentService) { }

  ngOnInit() {
    this.getEnvironments();
    console.log(this.environments);
  }

  getEnvironments(): void {
    this.environmentService.getEnvironments().subscribe(
      environmentsFromServer => {
        environmentsFromServer.forEach(environment => {
            this.environments.push(environment);
        });
      }
    );
  }

  onEditEnvironment(id: number) : void {
    this.router.navigate(['/environment/'+id]);
  }

  onDeleteEnvironment(id: number) : void {
    this.deleteEnvironment(id);
    this.router.navigate(['/environments']);
  }

  deleteEnvironment(id: number): void {
    this.environmentService.deleteEnvironment(id).subscribe(
      () => {
        for( var i = 0; i < this.environments.length; i++){ 
          if ( this.environments[i].id == id) {
            this.environments.splice(i, 1); 
          }
        }
      }
    );
  }
  
  trackByIndex(index: number, obj: any): any {
    return index;
  }

}
