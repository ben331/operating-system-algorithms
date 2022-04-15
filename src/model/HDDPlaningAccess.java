package model;

import java.util.Arrays;

public class HDDPlaningAccess {
	
	public int FCFS(int[] requests, int pos) {
		int ref = pos;
		int distance = 0;
		for(int i=0; i<requests.length; i++) {
			distance+= Math.abs(ref-requests[i]);
			ref = requests[i];
		}
		return distance;
	}
	
	public int SCAN(int[] requests, int pos, int max, int min, boolean directionUp) {
		int distance = 0;
		Arrays.sort(requests);
		
		if(directionUp) {
			int ref = pos<requests[0]? pos: requests[0];
			for(int i=0; i<requests.length; i++) {
				if(requests[i]<=pos) {
					distance += requests[i] - ref;
					ref = requests[i];
				}else {
					distance += 2*(requests[i] - ref);
					ref = requests[i];
				}
			}
			distance += 2*(max-requests[requests.length-1]);
		}else {
			int ref = pos>requests[requests.length-1]? pos: requests[requests.length-1];
			for(int i=requests.length-1; i>0; i--) {
				if(requests[i]>=pos) {
					distance += ref- requests[i];
					ref = requests[i];
				}else {
					distance += 2*(ref-requests[i]);
					ref = requests[i];
				}
			}
			distance += 2*(requests[requests.length-1]-min);
		}
		return distance;
	}
	
	public int C_SCAN(int[] requests, int pos, int max, int min) {
		int distance = max-min;
		Arrays.sort(requests);
		
		if(pos!=min) {
			if(pos==requests[0]) {
				distance -= requests[0]-min;
			}else {
				for(int i=1; i<requests.length; i++) {
					if(requests[i]>=pos) {
						distance -= pos - requests[i-1];
						break;
					}
				}
			}
		}
		return distance;
	}
}
