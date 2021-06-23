package com.ashley.dojooverflow.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ashley.dojooverflow.models.Tag;
import com.ashley.dojooverflow.repositories.TagRepo;


@Service
public class TagService {
			// adding the Tag repository as a dependency. alls all the methods in the
			// repository
			private final TagRepo tagRepo;

			public TagService(TagRepo tagRepo) {
				this.tagRepo = tagRepo;
			}

			// returns all the Tags
			public List<Tag> allTags() {
				return tagRepo.findAll();
			}

			// creates an Tag
			public Tag createTag(Tag t) {
				return tagRepo.save(t);
			}

			// retrieves a Tag
			public Tag findTag(Long id) {
//				    	in optional checks if present
				Optional<Tag> optionalTag = tagRepo.findById(id);
				if (optionalTag.isPresent()) {
//				        	if present, returns the tag
					return optionalTag.get();
				} else {
					return null;
				}
			}

//				    updates a Tag for API only
			public Tag updateTag(Long id, String subject) {
				Optional<Tag> optionalTag = tagRepo.findById(id);
				if (optionalTag.isPresent()) {
					Tag t = optionalTag.get();
					t.setSubject(subject);

					return tagRepo.save(t);
				} else {
					return null;
				}
			}

//				    update whole object
			public Tag updateTagObject(Tag t) {
				return tagRepo.save(t);
//				    	can also call the create function
			}

//				    deletes a Tag
			public Tag deleteTag(Long id) {
				tagRepo.deleteById(id);
				return null;

			}

		}

		
		
	
	

