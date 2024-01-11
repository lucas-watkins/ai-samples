from transformers import AutoModelForCausalLM, AutoTokenizer, TextStreamer

tok = AutoTokenizer.from_pretrained("microsoft/phi-2", trust_remote_code = True)
model = AutoModelForCausalLM.from_pretrained("microsoft/phi-2", trust_remote_code = True)
inputs = tok(["An increasing sequence: one,"], return_tensors="pt")
streamer = TextStreamer(tok)

     # Despite returning the usual output, the streamer will also print the generated text to stdout.
_ = model.generate(**inputs, streamer=streamer, max_new_tokens=20)
