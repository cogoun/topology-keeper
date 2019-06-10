import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EnvironmentsComponent } from './environments/environments.component';
import { EnvironmentFormComponent } from './environment-form/environment-form.component';

const routes: Routes = [
  { path: 'environments', component: EnvironmentsComponent },
  { path: 'environment', component: EnvironmentFormComponent },
  { path: 'environment/:id', component: EnvironmentFormComponent }
];

@NgModule({
  declarations: [],
  exports: [
     RouterModule
  ],
  imports: [
    RouterModule.forRoot(routes)
  ]
})
export class AppRoutingModule { }
