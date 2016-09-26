package edu.vanderbilt.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExerciseApplicationTests {

	@Autowired
	VideoService videoService;
	
	@Test
	public void contextLoads() {	
	}
	
	@Test
	public void videoServiceLoaded() {
		assertNotNull(videoService);
	}
	
	@Test
	public void addVideoReturnsAListOfVideos() {
		Video video = new Video();
		Iterable<Video> videos = videoService.addVideo(video);
		assertNotNull(videos);
		assertTrue(videos.iterator().hasNext());
	}

	@Test
	public void getVideoReturnsListOfVids(){
		Video video = new Video();
		videoService.addVideo(video);
		videoService.addVideo(video);
		Iterable<Video> videos = videoService.getVideo();
		assertNotNull(videos);
		assertTrue(videos.iterator().hasNext());
	}
	
	@Test
	public void deleteVid(){
		Video video = new Video();
		videoService.addVideo(video);
		videoService.deleteVid(video.getId());
		Iterable<Video> videos = videoService.getVideo();
		assertTrue(!videos.iterator().hasNext());
	}
}
