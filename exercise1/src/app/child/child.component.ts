import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css'],
})
export class ChildComponent implements OnInit {
  constructor() {}

  ngOnInit() {}

  @Input() boxColor: any;
  // here @input annotation is used for to access property from out side of component for that component
  @Input() placeholderText: any;

  count: number = 0;
  onCreate(inpval: any) {
    if (inpval.value.length > 0) {
      this.count = this.count + 1;
      this.inputEvent.emit(inpval.value);
      //here we sending data from child to parent with the help of @Output and EventEmitter
      //alert(inpval.value);
    }
  }

  @Output() inputEvent = new EventEmitter();
}
