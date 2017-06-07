import { Component, OnInit } from '@angular/core';
import { TranscriptService } from '../../services/transcript.service';
import { Transcript } from '../../dtos/transcript';

@Component({
    selector: 'app-transcript',
    templateUrl: './transcript.component.html'
})
export class TranscriptComponent implements OnInit {

    public symbol: string;
    public position: number;
    public aminoAcidLetter: string;
    public isLoading: boolean = false;
    public text: string = "No results";
    public transcripts: Transcript[];
    constructor(private transcriptService: TranscriptService) { }

    ngOnInit() {
    }

    getTranscripts() {
        this.isLoading = true;
        if (this.symbol != '' && this.aminoAcidLetter != '' && this.position > 0) {
            this.transcriptService.getTranscripts(this.symbol, this.position, this.aminoAcidLetter).subscribe(
                data => {
                    this.isLoading = false;
                    this.transcripts = data;
                },
                error => {
                    this.isLoading = false;
                    this.text = "Error Occurred";
                });
        }
    }

    clearOptions() {
        this.symbol = '';
        this.position = null;
        this.aminoAcidLetter = '';
        this.transcripts = null;
        this.text = "No results";
    }

    openLink(id: string) {
        return window.open('http://www.ensembl.org/id/' + id);
    }

}
